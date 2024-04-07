import Header from "../components/Header";
import mainhomepage from "../../assets/mainhomepage.jpg"
import { Carousel } from "@material-tailwind/react";
const HomePage = () => {
    return (
        <>
            <div className="h-screen">
                <Header role='main' />
                <Carousel transition={{ duration: 2 }} autoplay='true' loop='true' className="h-[600x]">
                    <img
                        src='../../assets/HC1.jpg'
                        alt="image 1"
                        className="h-full w-full object-cover"
                    />
                    <img
                        src='../../assets/HC2.jpg'
                        className="h-full w-full object-cover"
                    />
                    <img
                        src='../../assets/HC3.jpg'
                        alt="image 3"
                        className="h-full w-full object-cover"
                    />
                </Carousel>

            </div>
            {/* <div className="bg-[url('../../assets/mainhomepage.jpg')] h-screen bg-cover"> */}
            {/* </div> */}

        </>
    );
}

export default HomePage