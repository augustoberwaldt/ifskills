$(function() {
  $(".navbar-expand-toggle").click(function() {
    $(".app-container").toggleClass("expanded");
    return $(".navbar-expand-toggle").toggleClass("fa-rotate-90");
  });
  return $(".navbar-right-expand-toggle").click(function() {
    $(".navbar-right").toggleClass("expanded");
    return $(".navbar-right-expand-toggle").toggleClass("fa-rotate-90");
  });
});

$(function() {
  return $('select').select2();
});

$(function() {
  return $('.toggle-checkbox').bootstrapSwitch({
    size: "small"
  });
});

$(function() {
  return $('.match-height').matchHeight();
});

$(function() {
  return $('.datatable').DataTable({
    "dom": '<"top"fl<"clear">>rt<"bottom"ip<"clear">>'
  });
});

$(function() {
  return $(".side-menu .nav .dropdown").on('show.bs.collapse', function() {
    return $(".side-menu .nav .dropdown .collapse").collapse('hide');
  });
});

$('.delete').click(function () {
    return confirm("Are you sure?");
});


$('.datepicker').datepicker({
    format: "dd/mm/yyyy",
    maxViewMode: 1,
    todayBtn: true,
    clearBtn: true,
    autoclose: true,
    todayHighlight: true,
    toggleActive: true
});


$(document).ready(function() {
	  $('.summernote').summernote({
		  height: 250,                 // set editor height
		  minHeight: null,             // set minimum height of editor
		  maxHeight: null,             // set maximum height of editor
		  focus: true                  // set focus to editable area after initializing summernote
	  });
});


$(".star-rating").rating();



var substringMatcher = function(strs) {
	  return function findMatches(q, cb) {
	    var matches, substringRegex;

	    // an array that will be populated with substring matches
	    matches = [];

	    // regex used to determine if a string contains the substring `q`
	    substrRegex = new RegExp(q, 'i');

	    // iterate through the pool of strings and for any string that
	    // contains the substring `q`, add it to the `matches` array
	    $.each(strs, function(i, str) {
	      if (substrRegex.test(str)) {
	        matches.push(str);
	      }
	    });

	    cb(matches);
	  };
	};

//	var responsible = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California',
//		             	  'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii',
//		             	  'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana',
//		             	  'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota',
//		             	  'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire',
//		             	  'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota',
//		             	  'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island',
//		             	  'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont',
//		             	  'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'
//		             	];
	

 	$('#postResponsible .typeahead').typeahead({
 	  hint: true,
 	  highlight: true,
 	  minLength: 1
 	},
 	{
 	  name: 'responsible',
 	  source: substringMatcher(responsible)
 	});