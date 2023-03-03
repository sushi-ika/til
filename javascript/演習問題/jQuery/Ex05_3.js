$(document).ready(function() {
    $("#color").on('change', function() {
        let str = $("#color").val();
        setColor(str);
    });
});

function setColor(str){
    $('#txt').css('color', str);
}