function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}

$( document ).ready(function() {
   $('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
}); 
});





