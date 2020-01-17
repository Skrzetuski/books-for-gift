import React from 'react';

function Contact(props) {

    const email = <p>kontakt@pasiekaksiazek.pl</p>;

    const or = <p>lub</p>;

    const linkedin =<p><a href={"https://www.linkedin.com/in/krystian-gumi%C5%84ski-b77665147/"} target={"_blank"}>Profil Linkedin</a></p>;

    if(props.state === true){
        return (<section id="contact" >
            {email}
            {or}
            {linkedin}
        </section>);
    } else {
        return ("");
    }   
}

export default Contact;