(function ($) {
    $.fn.serializeFormJSON = function () {

        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
})(jQuery);

$(document).ready(function() {


	$("#studentForm").click(function (event) {
		console.log("i am at the event")
		event.preventDefault();

		let studentJSON = JSON.stringify($("#container").serializeFormJSON());
		console.log(studentJSON)
		$.ajax({
			type: "POST",
			url:"http://localhost:9090/student/addStudentForm",
			data: studentJSON,
			contentType: "application/json",
			dataType: "json",
			success: function (studentJSON) {
				$("#container")[0].reset();
				$("#solution").empty();
				$('#solution').append('<H3 align="center"> Great Good Job!! <H3><p>').show();

			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
				let errorObj = XMLHttpRequest.responseJSON;
				$("#solution").empty();
				if (errorObj.errorType === 'ValidationError') {

					let errorArray = errorObj.fieldErrors;
					let errorMessage = '<h3> Error(s)!! </h3>';
					errorMessage += "<p>";

					$.each(errorArray, function (index, e) {
						errorMessage = errorMessage + e.field + " : " + e.message + '<br>';
					});
					errorMessage += "</p>";

					$('#solution').append(errorMessage);
					$('#solution').show();

				} else {
					alert(" this error is not happen due to other error but not due to Validation error ")
				}


			}
		});

	});
});

// 	$("#categorySubmitBtn").click(function() {
//
// 		let data = JSON.stringify($("#categoryForm").serializeFormJSON());
// 		$.ajax({
// 			type : "POST",
// 			url : "http://127.0.0.1:9999/api/addCategory",
// 			data : data,
// 			contentType: "application/json",
// 			dataType : "json",
// 			success : function(data){
// 				$("#categoryForm")[0].reset();
// 				$("#result").empty();
// 				$('#result').append('<H3 align="center"> OK!! <H3><p>').show();
// 			},
// 			error: function(XMLHttpRequest, textStatus, errorThrown){
// 				console.log(XMLHttpRequest.responseJSON);
// 				$("#result").empty();
//
// 				if (XMLHttpRequest.responseJSON.errorType == "ValidationError") {
// 					let errorMsg = '<h3> Error(s)!! </h3>';
// 					errorMsg += "<p>";
// 					var errorList = XMLHttpRequest.responseJSON.fieldErrors;
// 					$.each(errorList, function(i, error) {
// 						errorMsg = errorMsg +error.message + '<br>';
// 					});
// 					errorMsg += '</p>';
// 					$('#result').append(errorMsg);
// 					$('#result').show();
// 				} else {
// 					alert(errorObject.responseJSON.errors(0)); // "non" Validation
// 				}
// 			}
// 		});
// 	});
// });