/**
 * 
 */

    	$(document).ready(function(){
			  $("#chatbutton").click(function(){
			    $("#togglechat").fadeToggle();
			  });
			});
		
		function button1_click() {

			$.ajax({
		  	    url: "chat",
		  	  	cache: false
		   }).done(function (fragment) {
		         $("#change").replaceWith(fragment);
		    });
		}
		
		function buttonback_click() {

			$.ajax({
		  	    url: "chatindex",
		  	  	cache: false
		   }).done(function (fragment) {
		         $("#change").replaceWith(fragment);
		    });
			stop();
		}

  	function submitFunction(val) {
  		var fromID = '<%= userID %>';
  		var toID = '<%= toID %>';
  		var chatContent = val;
  		$.ajax({
  				type: "POST",
  				url: "chatSubmit",
  				data: {
  					fromID: encodeURIComponent(fromID),
  					toID: encodeURIComponent(toID),
  					chatContent: encodeURIComponent(chatContent)
  				}
  		});
  		
  		$('#chatContent').val('');
  	}
  	
  	var lastID = 0;

  	function chatListFunction(type) {
  		var fromID = '<%=userID %>';
  		var toID = '<%= toID %>';
  		$.ajax({
  			type: "POST",
  			url: "chatList",
  			data: {
  				fromID: encodeURIComponent(fromID),
  				toID: encodeURIComponent(toID),
  				listType: type
  			},
  			success: function(data) {
         
  				var parsed = JSON.parse(data);
  				var result = parsed.result;
  				for(var i = 0; i < result.length; i++) {
  					if(result[i][0].value == fromID) {
  						result[i][0].value ='나';
  					}
  					addChat(result[i][0].value, result[i][2].value, result[i][3].value);
  				}
  				lastID = Number(parsed.last);
  				
  			}
  		});
  	}
  	function addChat(chatName, chatContent, chatTime) {
  		$('#chatList').append('<li class="incoming-message message">' + 
  				'<div class="message__content">' +
  				'<span class="message__bubble">' +
  				chatContent +
  				'</span>' +
  				'<span class="message__author">'+
  				chatName +
  				'</span>' +
  				'</div>' +
  				'<div class="media-body">' +
  				' </li>');
  		$('#togglechat').scrollTop($('#togglechat')[0].scrollHeight);
  	}
  	function getUnread() {
		$.ajax({
			type: "POST",
			url: "chatUnread",
			data: {
				userID: encodeURIComponent('<%= userID %>'),
			},
			success: function(result) {
				if(result >= 1) {
					showUnread(result);
				} else {
					showUnread('');
				}
			}
		});
	}
	function getInfiniteUnread() {
		setInterval(function() {
			getUnread();
		}, 4000);
	}
	function showUnread(result) {
		$('#unread').html(result);
	}
	
	function enterkey(val) {
        if (window.event.keyCode == 13) {
        	submitFunction(val) 
        }
 }
	
	$(document).ready(function() {
 			getUnread();
			getInfiniteUnread();
 	});
	
	function getInfiniteChat() {
  		refreshIntervalID = setInterval(function() {
  			chatListFunction(lastID);
  		}, 3000);
  		
  		}
	
	function stop(){
		  clearInterval(refreshIntervalID);
		}