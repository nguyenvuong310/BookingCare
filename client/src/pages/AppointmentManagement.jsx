import Header from "../components/Header";
import MenuAdmin from "../components/MenuAdmin";
import {
    CheckCircleIcon,
    CheckIcon,
    TrashIcon,
    PencilSquareIcon
} from "@heroicons/react/24/solid";
const Schedule = () => {
    const data = [
        {
            name: 'Pham Tung',
            phone: '0908123123',
            time: '9h',
            date: '25-Apr-2024',
            status: 0
        },
        {
            name: 'Pham Tung',
            phone: '0908123123',
            time: '9h',
            date: '25-Apr-2024',
            status: 1
        },
        {
            name: 'Pham Tung',
            phone: '0908123123',
            time: '9h',
            date: '25-Apr-2024',
            status: 1
        }
    ]

    return (
        <>
            <Header role='admin' />
            <div className="flex ">
                <MenuAdmin />
                <div className="w-full flex flex-col items-center ">
                    <div id='tableHeader' className="flex flex-1 py-[20px] px-[50px]  mb-[30px] max-h-[100px] w-full items-center">
                        <h2 className="flex-1 text-[30px] font-bold">Manage Appointments</h2>
                        <form class="min-w-[350px] ">
                            <label for="default-search" class="mb-2 text-sm font-medium text-gray-900 sr-only dark:text-white">Search</label>
                            <div class="relative">
                                <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                                    <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
                                    </svg>
                                </div>
                                <input type="search" id="default-search" class="block w-full p-4 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-purple-50 focus:ring-blue-500 focus:border-blue-500 " placeholder="Search Appointment..." required />
                                <button type="submit" class="text-white absolute end-2.5 bottom-2.5 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Search</button>
                            </div>
                        </form>
                    </div>
                    {/* SEARCH */}

                    <div className="">
                        <table class="round-md  table-auto divide-gray-200 ">
                            <thead class="bg-white ">
                                <tr>
                                    <th
                                        scope="col"
                                        class="px-[50px] py-4 text-left text-lg font-bold text-gray-900"
                                    >
                                        Name
                                    </th>
                                    <th
                                        scope="col"
                                        class="px-[50px] py-4 text-left text-lg font-bold text-gray-900"
                                    >
                                        Phone Number
                                    </th>
                                    <th
                                        scope="col"
                                        class="px-[50px] py-4 text-left text-lg font-bold text-gray-900"
                                    >
                                        Appointment Date & Time
                                    </th>
                                    <th
                                        scope="col"
                                        class="px-[50px] py-4 text-left text-lg font-bold text-gray-900"
                                    >
                                        Status
                                    </th>
                                    <th
                                        scope="col"
                                        class="px-[50px] py-4 text-left text-lg font-bold text-gray-900"
                                    >
                                        Action
                                    </th>

                                </tr>
                            </thead>
                            <tbody className="mt-1">
                                {data &&
                                    data.map((appoint, index) => {
                                        const createdAtDate = new Date(appoint.createdAt);
                                        const formattedCreatedAt =
                                            createdAtDate.toLocaleDateString("en-GB");
                                        const dateDate = new Date(appoint.date);
                                        const formattedDate =
                                            dateDate.toLocaleDateString("en-GB");
                                        return (
                                            <tr className="odd:bg-blue-50 even:bg-white">

                                                <td class="whitespace-nowrap px-[30px]  py-4 text-lg font-light text-gray-900">

                                                    <p class="w-[100px]  truncate">
                                                        {appoint.name}
                                                    </p>
                                                </td>
                                                <td class="whitespace-nowrap px-[30px] text-center py-4 text-lg font-light text-gray-900">
                                                    <p class="w-[150px]  truncate">
                                                        {appoint.phone}
                                                    </p>

                                                </td>
                                                <td class="whitespace-nowrap px-[30px] py-4  text-center text-lg font-light text-gray-900">
                                                    {appoint.date} at {appoint.time}
                                                </td>
                                                <td class="whitespace-nowrap px-[30px] py-4 text-left text-lg font-light text-gray-900">
                                                    {appoint.status ? (
                                                        <td class="whitespace-nowrap  py-4 text-left text-lg font-light text-gray-900">
                                                            <div type="div" class="min-w-[100px] text-center py-2.5 px-5  text-sm font-medium text-orange-400
                                                           
                                                            bg-orange-50 rounded-3xl border border-[2px] border-orange-400  ">
                                                                Booked
                                                            </div>

                                                        </td>
                                                    ) : (
                                                        <td class="whitespace-nowrap py-4 text-left text-lg font-light text-gray-900">
                                                            <div type="div" class="min-w-[100px] text-center py-2.5 px-5  text-sm font-medium text-green-400
                                                           
                                                           bg-green-50 rounded-3xl border border-[2px] border-green-400  ">
                                                                Open
                                                            </div>
                                                        </td>
                                                    )}
                                                </td>



                                                <td class="whitespace-nowrap px-[30px] py-4 text-left text-lg font-light text-gray-900">
                                                    <div className="flex space-x-7">
                                                        {appoint.status == 0 ? <button class="flex rounded-lg w-[100px] text-sm text-white bg-blue-300 h-[33px]   justify-self-center 
                                      hover:bg-white hover:text-blue-700   active:drop-shadow-none "
                                                            onClick={() => handleConfirmPrinted(appoint.id)}>
                                                            <div class="bg-blue-500 rounded-l-lg w-6 h-[33px] flex self-center ">
                                                                <CheckIcon class=" m-1 font-bold self-center font-white" />
                                                            </div>
                                                            <div class="p-2 rounded-r-lg self-center text-blue-700">
                                                                Confirm

                                                            </div>
                                                        </button> :
                                                            <button class="flex rounded-full h-[33px] w-[100px] text-sm p-1 justify-center  items-center  
                                    " disabled={true} onClick={() => handleConfirmPrinted(appoint.id)}>
                                                                <div class="border-2 border-blue-400  w-[33px] h-[33px] rounded-full flex justify-center ">
                                                                    <CheckCircleIcon class=" fill-blue-300 text-white self-center font-black" />
                                                                </div>

                                                            </button>}
                                                        <button>
                                                            <TrashIcon type='button' onClick={() => { }} className="w-[30px] text-red-500" />
                                                        </button>
                                                        <button>
                                                            <PencilSquareIcon type='button' onClick={() => { }} className="w-[25px] text-grey-800" />
                                                        </button>
                                                    </div>

                                                </td>
                                            </tr>
                                        );
                                    })}
                            </tbody>
                        </table>
                    </div>
                </div>


            </div>


        </>
    );
}

export default Schedule