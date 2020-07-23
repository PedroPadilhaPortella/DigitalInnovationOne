var request = $.ajax({
        url: urlServico,
        method: method,
        //data: JSON.stringify(requestData),
        data: requestData,
        dataType: "json",
        contentType: 'application/json; charset=utf-8'
    });

   
    request.done(function (responseData) {
       
        if (responseData.httpCode != 200) {

            onErrorFunction(responseData);
            return;
        }

        onSuccessFunction(responseData);
    });
    request.fail(function (xhr, status, error) {

        console.log(xhr);
        console.log(status);
        console.log(error);

        onErrorFunction(xhr);
    });
    request.always(function () {

        $(block_ele).unblock();
        $.unblockUI();
    });