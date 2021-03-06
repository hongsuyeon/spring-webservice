var index = {
    init: function(){
        var _this = this;
        $("#btn-save").on('click',function(){
            _this.save();
        });
    },
    save : function(){
        var data = {
            title : $("#title").val(),
            author : $("#author").val(),
            content : $("#content").val(),
        };
///posts/api/v1/posts
        $.ajax({
            type : 'POST',
            url : 'api/v1/posts',
            dataType : 'text',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href= '/';
        }).fail(function(err){
            alert(JSON.stringify(err));
        });
    }
};
index.init();