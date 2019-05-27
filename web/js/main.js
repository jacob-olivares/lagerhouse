/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(window).ready(function(){
    $('body').css('height', $(window).height());

    if($('main').height() > $('body').height()-$('header').height()){
            $('.container').css( 'overflow-y', 'scroll' );
    }
});


