$(document).ready(function(){
  // Load page choose-topic.html ketika button diklik
  $("#start").click(function(){
    window.location.href = "choose-topic.html";
  });
  // Load page insert-keyword.html ketika button diklik
  $("#choose-topic-button").click(function(){
    window.location.href = "insert-keyword.html";
  });
  $("#category").hide();
  $("#topic-choice input:radio").click(function(){
    var category;
    var categoryPolicyAndLaw = ["International", "National", "Regional"];
    var categoryEntertainment = ["Cinema", "Music", "Gossip"];
    var categoryTravelling = ["Place", "Accomodation", "Culinary"];
    var categoryTechnology = ["Invention", "Gadget", "Internet"];
    var printTab;
    if ($(this).is("#policy-and-law")) {
      category = "Policy and Law";
      printTab = categoryPolicyAndLaw;
    } else if ($(this).is("#entertainment")) {
      category = "Entertainment";
      printTab = categoryEntertainment;
    } else if ($(this).is("#travelling")) {
      category = "Travelling";
      printTab = categoryTravelling;
    } else {
      category = "Technology";
      printTab = categoryTechnology;
    }
    $("#category").find("h1").text("Topic " + category);
    $("#keyword1-label").text("Keyword " + printTab[0]);
    $("#keyword2-label").text("Keyword " + printTab[1]);
    $("#keyword3-label").text("Keyword " + printTab[2]);
    $("#category").show();
  });
  //$("#topic-choice input:radio").prop("checked", true).trigger("click");
  
});
