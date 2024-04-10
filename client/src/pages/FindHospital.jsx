import Header from "../components/Header";
import GGM from "../assets/GGM.jpg"
import {
    Typography,
} from "@material-tailwind/react";
const FindHospital = () => {
    return (
        <>
            <Header role='user' />
            <div className="grid grid-cols-2 w-full lg:flex-row">
                <div className="grid flex-grow h-32 card rounded-box place-items-center">
                    <form className="ml-20">
                        <div className="mt-10 grid gap-x-6 gap-y-8 sm:grid-cols-6">
                            <div className="sm:col-span-4">
                                <label className="block text-sm font-bold leading-6">
                                    Which problem are you in?
                                </label>
                                <div className="mt-2">
                                    <select

                                        className="block w-full rounded-md border-0 py-1.5 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6"
                                    >
                                        <option>problem 1</option>
                                        <option>problem 2</option>
                                        <option>problem 3</option>
                                    </select>
                                </div>
                            </div>

                            <div className="sm:col-span-4">
                                <label className="block text-sm font-bold leading-6 ">
                                    What is your symptom?
                                </label>
                                <div className="mt-2">
                                    <select

                                        className="block w-full rounded-md border-0 py-1.5  shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6"
                                    >
                                        <option>problem 1</option>
                                        <option>problem 2</option>
                                        <option>problem 3</option>
                                    </select>
                                </div>

                            </div>
                            <div className="sm:col-span-4">
                                <label className="block text-sm font-bold leading-6 ">
                                    Which hospital / department do you want to <br /> have an appointment?
                                </label>
                                <div className="mt-2">
                                    <select

                                        className="block w-full rounded-md border-0 py-1.5  shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6"
                                    >
                                        <option>problem 1</option>
                                        <option>problem 2</option>
                                        <option>problem 3</option>
                                    </select>
                                </div>

                            </div>
                            <div className="sm:col-span-4">
                                <label className="block text-sm font-bold leading-6 ">
                                    When will you be available for the appointment?
                                </label>
                                <div className="mt-2">
                                    <input type="date"

                                        className="block w-full rounded-md border-0 py-1.5  shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6"
                                    >
                                    </input>
                                </div>
                            </div>
                            <div className="sm:col-span-4">
                                <label className="block text-sm font-bold leading-6 ">
                                    Choose the time
                                </label>
                                <div className="mt-2">
                                    <input type="time"

                                        className="block w-full rounded-md border-0 py-1.5  shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6"
                                    >
                                    </input>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

                <div className="grid flex-grow h-32 card rounded-box place-items-center">
                    <img
                        className="mt-20 mr-20 h-full w-full px-10 rounded-lg"
                        src={GGM}
                        alt="nature image"
                    />
                    <button id="upLoadBtn" type="button" className="enabled:bg-blue-600 justify-self-end rounded-xl px-5 py-1.5
                                        text-white  enabled:active:bg-blue-700 shadow enabled:hover:bg-blue-700 enabled:hover:shadow-lg outline-none 
                                        enabled:focus:outline-none mr-20 mt-16 
                                        items-center ease-linear transition-all duration-150 enabled:active:ring ring-blue-400 enabled:focus:ring
                                        disabled:bg-blue-400">
                        DONE
                    </button>
                </div>
            </div>

        </>
    );
}

export default FindHospital