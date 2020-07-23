function consultar(){
    $(".progress-bar").show();
    var cep = document.getElementById("cep").value
    var url = `https://viacep.com.br/ws/${cep}/json/`;
    console.log(cep)
    console.log(url)
    $.ajax({
        url: url,
        type: "GET",
        success: function(response){
            console.log(response);
            document.getElementById("logradouro").innerHTML = response.logradouro;
            document.getElementById("bairro").innerHTML = response.bairro;
            document.getElementById("cep_local").innerHTML = cep;
            //document.getElementById("localidade").innerHTML = response.localidade;
            //document.getElementById("uf").innerHTML = response.uf;
            $("#localidade").html(response.localidade)
            $("#uf").html(response.uf)
            $(".progress-bar").hide();
            $(".cep").show();
        }
    })
}
$(function(){
    $(".cep").hide();
    $(".progress-bar").hide();
});

