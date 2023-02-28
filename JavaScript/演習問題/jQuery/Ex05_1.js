
$(document).ready(function(){
    $('#btn').on('click', function(){
        let str = $("input[name='fruit']:checked").val();
        $('#txt').val(str);
    });
});