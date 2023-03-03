'use strict';
        
let count = 0;

const openDialog=()=>{
    count += 1;
    alert(count + "回押しました");
}

const clearCount=()=>{
    count = 0;
    alert("リセットしました");
}