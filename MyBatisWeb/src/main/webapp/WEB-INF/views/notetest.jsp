<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Summernote with Bootstrap 5</title>
    <!-- include libraries(jQuery, bootstrap) -->
    <script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />
    <script type="text/javascript" src="cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

    <!-- include summernote css/js-->
    <link href="summernote-bs5.css" rel="stylesheet">
    <script src="summernote-bs5.js"></script>

    <!-- summer note-->
    <link rel="stylesheet" href="../summernote/font/summernote.eot">
    <link rel="stylesheet" href="../summernote/font/summernote.ttf">
    <link rel="stylesheet" href="../summernote/font/summernote.woff">
    <link rel="stylesheet" href="../summernote/font/summernote.woff2">
    <script src="../summernote/lang/summernote-ko-KR.js"></script>
    <script>
        $('#summernote').summernote({
        placeholder: 'Hello Bootstrap 5',
        tabsize: 2,
        height: 100
        }); 
    
        $(document).ready(function() {
            //여기 아래 부분
            $('#summernote').summernote({
                height: 300,                 // 에디터 높이
                minHeight: null,             // 최소 높이
                maxHeight: null,             // 최대 높이
                focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
                lang: "ko-KR",					// 한글 설정
                placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
                
            });
        });
    
        // 서머노트에 text 쓰기
        $('#summernote').summernote('insertText', '써머노트에 쓸 텍스트');
    
    
        // 서머노트 쓰기 비활성화
        $('#summernote').summernote('disable');
    
        // 서머노트 쓰기 활성화
        $('#summernote').summernote('enable');
    
    
        // 서머노트 리셋
        $('#summernote').summernote('reset');
    
    
        // 마지막으로 한 행동 취소 ( 뒤로가기 )
        $('#summernote').summernote('undo');
        // 앞으로가기
        $('#summernote').summernote('redo');
	</script>
  </head>
  <body>
    <form method="post">
        <textarea id="summernote" name="editordata"></textarea>
    </form>
      
  </body>
</html>