var points = document.getElementsByClassName("point");
var arrayOfPoints = Array.from(points);


function positionPoints(arrayOfPoints) {
    var i = 50
    arrayOfPoints.forEach(element => {
        element.style.left = (i + "px");
        i += 28;
    });
}


function moveSinglePointUp(point, upOrDown) {
    var delta;
    if (upOrDown == "up") delta = 1;
    else delta = (-1);
    
    var currentPosition = parseInt(window.getComputedStyle(point).bottom.replace('px', ''));
    currentPosition += delta;
    point.style.bottom = currentPosition + 'px';
}

function moveEveryPoint(arrayOfPoints, UpOrDown) {
    var position;
    if (UpOrDown == "up") position = "60px";
    else position = "30px";
    
    for (var i = 0; i < arrayOfPoints.length; i++) {
        if (window.getComputedStyle(arrayOfPoints[i]).bottom != position) {
            moveSinglePointUp(arrayOfPoints[i], UpOrDown);
            break;
        }
        continue;
    }
}

function IsEveryPointAtDesiredPosition(arrayOfPoints, UpOrDown) {
    var position;
    if (UpOrDown == "up") position = "60px";
    else position = "30px";
    
    var filteredArray = arrayOfPoints.filter(element => {
        return element.style.bottom != position;
    })
    return filteredArray.length == 0;
}





positionPoints(arrayOfPoints);

var position = "up";
var timer = setInterval(function () {
    
    if (IsEveryPointAtDesiredPosition(arrayOfPoints, position)) {
        if (position == "up") position = "down";
        else position = "up";
    }
    else {
        moveEveryPoint(arrayOfPoints, position);
    }
}, 1000 / 60);
