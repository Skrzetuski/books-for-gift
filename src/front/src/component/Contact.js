import React from 'react';

function Contact(props) {

    if(props.state === true){
        return (<section id="contact" >Kontakt</section>);
    } else {
        return ("");
    }   
}

export default Contact;