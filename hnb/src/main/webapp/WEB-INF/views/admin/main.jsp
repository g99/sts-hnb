<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function() {
	$.getJSON(context+'/admin/member_list/1',function(data) {
		var table = "<div id='boardList'><h1 align=center style='color:white;margin-bottom:30px'>회원목록</h1>"
		+"<TABLE id='tab_boardList'>"
		+"<TR><TD COLSPAN='5' style='text-align:right;'> 회원수 : "+data.count+"</TD></TR>"
		+"<TR ALIGN=CENTER><TD WIDTH=10%><B>번호</B></TD>"
		+"<TD WIDTH=20%><B>아이디</B></TD>"
		+"<TD WIDTH=20%><B>회원명</B></TD>"
		+"<TD WIDTH=30%><B>이메일</B></TD>"
		+"<TD WIDTH=18%><B>가입일</B></TD></TR>";
		
		$.each(data.list, function(index, value) {
			table += "<TD WIDTH=10% ALIGN=CENTER>"+(index+1)+"</TD>"
					+"<TD WIDTH=20% ALIGN=CENTER>"+this.id+"</TD>"
					+"<TD WIDTH=20% ALIGN=CENTER><A HREF='BoardContent.jsp'>"+this.name+"</A></TD>"
					+"<TD WIDTH=30% ALIGN=LEFT>"+this.email+"</TD>"
					+"<TD WIDTH=18% ALIGN=CENTER>"+this.regdate+"</TD></TR>";
		});
		table +="</TABLE></div>";
		$('.mainView').html(table);
	});
});	
 $('#btn_admin_table').click(function() {
    $('#btn_admin_table').submit();
  });
 var Admin = {
		 memberList : function(url) {
		$.getJSON(url,function(data) {
			var table = "<div id='div_boardList'><h1 align=center style='color:white;margin-bottom:30px'>회원목록</h1>"
			+"<TABLE id='boardList'>"
			+"<TR ALIGN=CENTER><TD WIDTH=10%><B>번호</B></TD>"
			+"<TD WIDTH=20%><B>아이디</B></TD>"
			+"<TD WIDTH=20%><B>회원명</B></TD>"
			+"<TD WIDTH=30%><B>이메일</B></TD>"
			+"<TD WIDTH=18%><B>가입일</B></TD></TR>"
			/* +"<c:forEach var='member' items='${memberList}' varStatus='status'><TR>"
			+"<TD WIDTH=10% ALIGN=CENTER>${status.index+1}</TD>"
			+"<TD WIDTH=20% ALIGN=CENTER>${member.id}</TD>"
			+"<TD WIDTH=20% ALIGN=CENTER><A HREF='BoardContent.jsp'>${member.name}</A></TD>"
			+"<TD WIDTH=30% ALIGN=LEFT>${member.email}</TD>"
			+"<TD WIDTH=18% ALIGN=CENTER>${member.regdate}</TD></TR></c:forEach>" */
			+"</TABLE></div>";
			$('.mainView').empty();
			$('.mainView').html(table);
		});
	},
	memberNotExist : function() {
		var table ='<h1>회원목록</h1><table id="boardList"><tr><th>아이디</th>';
			table += '<th>이름</th><th>성별</th><th>생년원일</th><th>전화번호</th><th>이메일</th></tr>';
			table += '<tr><td colspan="6"><h2>회원목록이 없습니다.</h2></td></tr></table>';
			$(table).appendTo($('#main_right').empty());
	}
 };
 </script>