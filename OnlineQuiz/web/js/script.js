/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// grab parts of our HTML


function countplus() {
    var time = 10;
    var cookieName = "temp_value";
    var timer = document.getElementById("timer");
    var temp_value = getCookie(cookieName) ? getCookie(cookieName) : time;
    timer.innerHTML = "Time Remaining: " + convertTimer(temp_value--);
    document.cookie = "temp_value=" + (temp_value);
    if (temp_value == 0) {
        location.href = "Result"
        document.cookie = "temp_value=" + time;
    }
}
setInterval(countplus, 1000);

function convertTimer(s) {
    hou = Math.floor(s / 3600);
    min = Math.floor((s / 3600 - hou) * 60);
    sec = s - hou * 3600 - min * 60;
    return ('0' + hou).slice(-2) + ':' + ('0' + min).slice(-2) + ':' + ('0' + sec).slice(-2);
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}