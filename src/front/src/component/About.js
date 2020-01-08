import React from 'react';

function About(props) {

    const text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam vitae ligula eu odio finibus maximus. Nam a eros urna. Ut in mi a arcu facilisis egestas vitae mattis nisi. Fusce sed risus eu turpis dictum sollicitudin vel a erat. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Proin a justo orci. Aenean faucibus libero est, ut elementum enim fringilla a. Donec iaculis, est quis tincidunt finibus, orci sem iaculis dolor, ac feugiat urna dui quis libero. Maecenas sollicitudin enim et gravida viverra. Cras maximus dictum est, quis posuere libero egestas nec. Sed eget nulla diam. Quisque quam odio, interdum eu aliquam eget, sodales tincidunt ante. Morbi quis neque enim. Proin placerat lacus viverra sapien scelerisque iaculis. Suspendisse consectetur odio eget tristique commodo. In venenatis enim feugiat, consectetur neque sed, finibus nunc. Duis lorem nisl, rutrum nec finibus in, tristique sed elit. Vivamus bibendum nisl felis, id mollis enim vulputate condimentum. Mauris suscipit lobortis elit. Sed elementum erat sed cursus semper. Fusce ex leo, semper eu malesuada at, porttitor vel ex. Suspendisse gravida tincidunt sem, sed congue diam porttitor nec.";

    if(props.state === true) {
        return (<section id="about" className="text-justify">{text}</section>);
    } else {
        return ("");
    }
}

export default About;