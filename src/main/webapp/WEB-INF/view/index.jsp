<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>asd</title>
</head>
<body>
    <div>휴대폰 인증</div>
    <div><input type="text" id="inputPhoneNumber" placeholder="-제외 번호 입력">
    <input type="button" id="sendPhoneNumber" value="번호확인"></div>
    <hr>
    <div><input type="text" id="inputCertifiedNumber" placeholder="인증번호 입력"></div>
    <div><input type="button" id="checkBtn" value="확인"></div>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script>
    $('#sendPhoneNumber').click(function(){
        let phoneNumber = $('#inputPhoneNumber').val();
        Swal.fire('인증번호 발송 완료!')

        $.ajax({
            type: "GET",
            url: "/check/sendSMS",
            data: {
                "phoneNumber" : phoneNumber
            },
            success: function(res){
                $('#checkBtn').click(function(){
                    console.log(res);
                    console.log($('inputCertifiedNumber').val());
                    if($.trim(res) ==$('#inputCertifiedNumber').val()){
                        Swal.fire(
                            '인증성공!',
                            '휴대폰 인증이 정상적으로 완료되었습니다.',
                            'success'
                        )

                        // $.ajax({
                        //     type: "GET",
                        //     url: "/update/phone",
                        //     data: {
                        //         "phoneNumber" : $('#inputPhoneNumber').val()
                        //     }
                        // })
                        // document.location.href="/home";
                    }else{
                        Swal.fire({
                            icon: 'error',
                            title: '인증오류',
                            text: '인증번호가 올바르지 않습니다!',
                            footer: '<a href="/home">다음에 인증하기</a>'
                        })
                    }
                })


            }
        })
    });
</script>
</body>
</html>
