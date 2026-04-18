async function loadStudents() {
    const nameFilter = document.getElementById('nameFilter').value;
    const hobbyFilter = document.getElementById('hobbyFilter').value;

    const url = new URL('/api/students', window.location.origin);
    if (nameFilter) url.searchParams.append('name', nameFilter);
    if (hobbyFilter) url.searchParams.append('hobby', hobbyFilter);
    console.log(url)
    const response = await fetch(url);
    const students = await response.json();

    const tbody = document.getElementById('students-tbody');
    tbody.innerHTML = '';

    students.forEach(s => {
        const hobbies = s.hobbies.map(h => h.name).join(', ');
        console.log(hobbies)
        const row = `<tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.surname}</td>
            <td>${s.age}</td>
            <td>${hobbies}</td>
            </tr>`;
        tbody.innerHTML += row;
    });
}