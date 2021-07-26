"use strict"
window.addEventListener("load",function(){
    this.document.querySelectorAll(".needs-validation").forEach( formulario => {
        console.log(formulario);
        formulario.addEventListener("submit",e => {

            if(formulario.checkValidity() === false){
                e.preventDefault();
                e.stopPropagation();
            }
            formulario.classList.add("was-validated");
        });
    });
});