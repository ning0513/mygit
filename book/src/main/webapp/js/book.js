$(function(){
	
	function loadPageBooks () {
		var p = $("#cpage").html();
		var url = "loadBooks/"+p+"/10.do";
		$.getJSON(url,function(data){
			for (var i = 0 ;i < data.length ;i++) {
				var temp ="<ul>";
				temp += "<li>" + data[i].id + "</li>";
				temp += "<li>" + data[i].name + "</li>";
				temp += "<li>" + data[i].author + "</li>";
				temp += "<li>" + data[i].price + "</li>";
				temp += "<li>" + data[i].info + "</li>";
				temp += "<li><a href='#'>删除</a> </li>";
				temp += "</ul>";
				$(".container").append(temp);
			}
			$("#cpage").html(parseInt(p)+1);
		});

	}
	
	loadPageBooks();
	
	$("#loadMore").click(loadPageBooks);
	
			
	$(document).on("click",".container a",function(){
		
		if(confirm("确认删除？")){
			var id = $(this).parents("ul").children().first().html();
	    	var $myA = $(this);
	  		var url = "delete/"+id+".do";
	  		$.get(url,function(data){
	  			if(data==1){
	  				 $myA.parents("ul").remove();
	  				 var p = ($("#cpage").html()-1) * 10;
					 var url = "loadBooks/"+p+"/1.do";
	  				 $.getJSON(url,function(data){
	  				 	var temp ="<ul>";
						temp += "<li>" + data[0].id + "</li>";
						temp += "<li>" + data[0].name + "</li>";
						temp += "<li>" + data[0].author + "</li>";
						temp += "<li>" + data[0].price + "</li>";
						temp += "<li>" + data[0].info + "</li>";
						temp += "<li><a href='#'>删除</a> </li>";
						temp += "</ul>";
						$(".container").append(temp);
	  				 });
	  			}
	  		});
		}
	});
});
