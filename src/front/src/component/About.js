import React from 'react';

function About(props) {


    const header = <h1>Kim jest Ula?</h1>;

    const p1 = <p className="mt-3">Ula jest dziewczyną, która nie przyjmuje prezentów w formie gotówki.
                       Natomiast zawsze chętnie znajdzie miejsce na kolejną papierową książkę do
                       swojej stale rosnącej biblioteczki ;> Ale! Pamiętaj żeby zamieścić dedykację - inaczej
                       dostaniesz zwrot ;3</p>;

    const p2 = <p>Projekt powstał na moje wewnętrzne potrzeby ułatwienia sobie życia ;3</p>;

    const headerTech = <h1>Technologie</h1>;

    const p1Tech = <p>Projekt oparty jest o takie technologie jak React, Spring Boot oraz AWS.</p>;

    if(props.state === true) {
        return (<section id="about" className="text-justify" >
                    {header}
                    {p1}
                    {p2}

                    {headerTech}
                    {p1Tech}
                </section>);
    } else {
        return ("");
    }
}

export default About;