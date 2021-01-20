function consultar(){
    var cep = document.getElementById("cep").value
    var url = `https://viacep.com.br/ws/${cep}/json/`;
    $.ajax({
        url: url,
        type: "GET",
        success: function(response){
            console.log(response);
            document.getElementById("log").innerHTML = response.logradouro;
            document.getElementById("bairro").innerHTML = response.bairro;
            //document.getElementById("local").innerHTML = response.localidade;
            //document.getElementById("uf").innerHTML = response.uf;
            $("#local").html(response.localidade)
            $("#uf").html(response.uf)
        }
    })
}