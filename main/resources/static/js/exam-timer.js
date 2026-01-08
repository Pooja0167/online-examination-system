function startTimer(duration) {
    var timer = duration, minutes, seconds;
    var display = document.getElementById('timer');
    var interval = setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            clearInterval(interval);
            alert("Time's up! Your exam will be submitted automatically.");
            document.forms[0].submit();
        }
    }, 1000);
}
