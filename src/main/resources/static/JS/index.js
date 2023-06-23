document.addEventListener('DOMContentLoaded', function () {
    var calendarEl = document.getElementById('calendar');
    let user_idx = localStorage.getItem("idx");

    if (user_idx) {
        let login = document.getElementById("login");
        login.style.display = "none";
        let logout = document.getElementById("logout");
        logout.style.display = "block";

        let event_data = findAllSchedule(user_idx);
        document.getElementById("color_input").value = localStorage.getItem("color");

        var calendar = new FullCalendar.Calendar(calendarEl, {
            timeZone: 'Asia/Seoul',
            initialView: 'dayGridMonth',
            headerToolbar: {
                start: 'multiMonthYear,dayGridMonth,timeGridWeek,listWeek custom',
                center: 'title',
                end: 'prevYear,prev,next,nextYear'
            },
            selectable: true,
            editable: true,
            customButtons: {
              custom: {
                  text: "custom",
                  click: function () {
                      customFunction();
                  }
              }
            },
            select: function (info) {
                selectFunction(info, user_idx, this);
            },
            eventClick: function (info) {
                deleteSchedule(info, user_idx);
            },
            events: event_data
        });
    } else {
        var calendar = new FullCalendar.Calendar(calendarEl, {
            timeZone: 'Asia/Seoul',
            initialView: 'dayGridMonth',
            headerToolbar: {
                start: 'multiMonthYear,dayGridMonth,timeGridWeek,listWeek',
                center: 'title',
                end: 'prevYear,prev,next,nextYear'
            }
        })
    }

    calendar.render();
});

function saveCustom() {
    let user_idx = localStorage.getItem("idx");
    let eventColor = document.getElementById("color_input").value;
    localStorage.setItem("color", eventColor);

    $.ajax({
        url: "api/v1/user/save",
        method: "PATCH",
        contentType: "application/json",
        data: JSON.stringify({
            user_idx: user_idx,
            color: eventColor
        }),
        success: function () {
            console.log("Save Custom success");
        },
        error: function (request,status,error) {
            alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
        }
    })
}

function customFunction() {
    var modal = new bootstrap.Modal(document.getElementById('modal'), {});
    var eventColor = document.getElementById("color_input");
    eventColor.value = localStorage.getItem("color");
    modal.show();
}

function deleteSchedule(info, user_idx) {
    let confirmCallback = function () {
        $.ajax({
            url: "api/v1/calendar/delete",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                title: info.event.title,
                start: info.event.startStr,
                end: info.event.endStr,
                user_idx: user_idx
            }),
            success: function () {
                console.log("delete schedule success");
            },
            error: function (request,status,error) {
                alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
            }
        });
        info.event.remove();
    }

    if (confirm("'" + info.event.title + "' 일정을 삭제하시겠습니까?")) {
        confirmCallback();
    }
}

function logOutFunction() {
    localStorage.clear();
    location.href = "index.html";
}

function findAllSchedule(user_idx) {
    let returnData;

    $.ajax({
        url: "api/v1/calendar/all/" + user_idx,
        type: "GET",
        async: false,
        success: function (data) {
            console.log("findAllSchedule success");
            returnData = data;
        },
        error: function (request,status,error) {
            alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
        }
    })

    return returnData;
}

function selectFunction(info, user_idx,calendar) {
    let title = prompt("일정을 입력해주세요.");

    if (title && user_idx) {
        let eventColor = document.getElementById("color_input").value;

        $.ajax({
            url: "api/v1/calendar/add",
            type: "POST",
            contentType: 'application/json',
            data: JSON.stringify({
                title: title,
                start: info.startStr,
                end: info.endStr,
                user_idx: user_idx,
                color: eventColor
            }),
            success: function (data) {
                console.log("Insert schedule success");
            },
            error: function (request,status,error) {
                alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
            }
        });
        calendar.addEvent({
            title: title,
            start: info.startStr,
            end: info.endStr,
            color: eventColor
        });
    }
}