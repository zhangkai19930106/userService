$(function () {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userName: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 18,
                        message: '用户名长度必须在6到18位之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '用户名只能包含大写、小写、数字和下划线'
                    }
                }
            },
            passWord:{
                notEmpty: {
                    message: '密码不能为空'
                }
            },
            realName:{
                notEmpty: {
                    message: '姓名不能为空'
                }
            },
            realId:{
                notEmpty: {
                    message: '身份证号码不能为空'
                },
                creditCard:{
                    message:'身份证号码输入错误'
                }
            },
            phoneNum:{
                validators:{
                    notEmpty: {
                        message: '手机号码不能为空'
                    },
                    phone:{
                        message:'请输入正确的手机号码'
                    }
                }
            },
            mailAddr: {
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    emailAddress: {
                        message: '邮箱地址格式有误'
                    }
                }
            }
        }
    });
});