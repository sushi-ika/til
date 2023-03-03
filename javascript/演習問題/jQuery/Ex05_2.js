$(document).ready(function() {
    $('#fruit').on('change', function() {
        let str = $("#fruit").val();
        $('#btn').on('click', function(){
            translate(str)
        });
    });
});

function translate(str){
     switch(str){         
        case 'りんご':
            str = 'apple';
            break;
        case 'ぶどう':
            str = 'grape';
            break;
        case 'みかん':
            str = 'orange';
            break;
        default:
            str = 'not select';
     }
     $('#txt').val(str);
}