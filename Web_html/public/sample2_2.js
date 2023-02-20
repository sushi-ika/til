function init(){
    let a = 1;
    let b = "1";
    
    if(a === b){
        document.write("値も型も同じです。")
    }else if(a == b){
        document.write("値は同じですが型は違います。")
    }else{
        document.write("値が違います。")
    }
}