import React, {useState} from 'react';

import About from './About';
import Contact from './Contact';
import List from './List';

function Nav() {

    const nav = ["Lista", "O projekcie", "Kontakt"];

    const [about, setAbout] = useState(false);

    const [contact, setContact] = useState(false);

    const [list, setList] = useState(true);

    const HideAndShowComponent = (e) => {
        switch (e.target.getAttribute('value')) {
            case "Kontakt":
                setList(false);
                setAbout(false);
                setContact(true);
                break;

            case "O projekcie":
                setAbout(true);
                setContact(false);
                setList(false);
                break;

            case "Lista":
                setAbout(false);
                setContact(false);
                setList(true);
                break;

            default:
                break;
        }
    };

    const navbar = nav.map((name) =>
        <li onClick={HideAndShowComponent} value={name} className="list-group-item" key={name}>{name}</li>);
    return (
        <div>

            <nav className="nav justify-content-center font-weight-bold">
                <ul className="list-group list-group-horizontal">
                    {navbar}
                </ul>
            </nav>

            <section id="content" className="container">
                <About state={about}/>
                <Contact state={contact}/>
                <List state={list}/>
            </section>
        </div>
    );
}

export default Nav;