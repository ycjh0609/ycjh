


var TOCKEN = "";

function fn_setHeader(request){
    request.setRequestHeader("Authorization",TOCKEN);
    request.setRequestHeader("Content-Type","application/json");
}

function fn_callView(selector,url){
    $.ajax({
        url:url
        ,dataType:"html"
        ,beforeSend:function(request){
            //loading animation
            fn_setHeader(request);
        }
        ,success:function(html){
            $(selector).html(html);
        }
        ,fail:function(){

        }
        ,error:function(){

        }
        ,complete:function(){
            //end loading animation
        }




    })
}