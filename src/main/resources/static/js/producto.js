(function(){
    var listaBotonesEditar = document.querySelectorAll(".editarProducto");
    listaBotonesEditar.forEach(item =>{
        item.addEventListener("click", e=>{
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
        })
    })
})();