const API_BASE = (window.location.port === "5500" || window.location.protocol === "file:") 
    ? "http://localhost:8080" 
    : "";

function showCourses(){
    fetch(`${API_BASE}/courses`) // API Endpoint
    .then((response) => response.json())
    .then((courses) => {
        const dataTable = document.getElementById("coursetable");
        dataTable.innerHTML = "";
        courses.forEach(course => {
            var row = `<tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.trainer}</td>
            <td>${course.durationInWeeks}</td>
            </tr>`;

            dataTable.innerHTML += row;
        });
    });
}

function showEnrolledStudents(){
    fetch(`${API_BASE}/courses/enrolled`) // API Endpoint
    .then((response) => response.json())
    .then((students) => {
        const dataTable = document.getElementById("enrolledtable");
        dataTable.innerHTML = "";
        students.forEach(student => {
            var row = `<tr>
            <td>${student.name}</td>
            <td>${student.emailId}</td>
            <td>${student.courseName}</td>
            </tr>`;

            dataTable.innerHTML += row;
        });
    });
}
