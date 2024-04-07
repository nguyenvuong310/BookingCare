import HeaderAdmin from "../components/HeaderAdmin";
import Popup from "../components/PopUp";
import { React, useState } from "react";


import { 
    PencilIcon, 
    EyeIcon,
    TrashIcon,
} from "@heroicons/react/24/solid";

import {
    MagnifyingGlassIcon,
    PlusCircleIcon,
} from "@heroicons/react/24/outline";

import {
  Card,
  CardHeader,
  Typography,
  Button,
  CardBody,
  IconButton,
  Tooltip,
  Input,
} from "@material-tailwind/react";
 
const TABLE_HEAD = ["ID", "Fullname", "Gender", "Qualification", ""];
 
const data = [
  {
    id: "1",
    name: "doctor1",
    gender: "Male",
    qualification: "qual1",
  },
  {
    id: "2",
    name: "doctor2",
    gender: "Male",
    qualification: "qual2",
  },
  {
    id: "3",
    name: "doctor3",
    gender: "Male",
    qualification: "qual3",
  },
  {
    id: "4",
    name: "doctor4",
    gender: "Male",
    qualification: "qual4",
  },

];




const Doctor = () => {
    const [buttonPopup, setButtonPopup] = useState(false);
    const togglePopup = () => {
        setButtonPopup(!buttonPopup);
    }

    const [inputText, setInputText] = useState("")
    let inputHandler = (e) => {
        //convert input text to lower case
        var lowerCase = e.target.value.toLowerCase();
        setInputText(lowerCase);
    };

    const TABLE_ROWS = data.filter((el) => {
        //if no input the return the original
        if (inputText === '') {
            return el;
        }
        //return the item which contains the user input
        else {
            return el.name.toLowerCase().includes(inputText)
        }
    })
    return (
        <>
            <HeaderAdmin />
            <div>
                <Card className="h-full w-full">
                <CardHeader floated={false} shadow={false} className="rounded-none">
                    <div className="mb-4 flex flex-col justify-between gap-8 md:flex-row md:items-center">
                    <div>
                        <Typography variant="h5" color="blue-gray">
                        Doctor List
                        </Typography>
                        {/* <Typography color="gray" className="mt-1 font-normal">
                        Doctor List
                        </Typography> */}
                    </div>
                    <div className="flex w-full shrink-0 gap-2 md:w-max">
                        <div className="w-full md:w-72">
                        <Input
                            label="Search"
                            icon={<MagnifyingGlassIcon className="h-5 w-5" />}
                            onChange={inputHandler}
                        />
                        </div>
                        <Button className="flex items-center gap-3" size="sm">
                            Add <PlusCircleIcon strokeWidth={2} className="h-4 w-4" /> 
                        </Button>
                    </div>
                    </div>
                </CardHeader>
                <CardBody className="overflow-auto px-0">
                    <table className="w-full min-w-max table-auto text-left">
                    <thead>
                        <tr>
                        {TABLE_HEAD.map((head) => (
                            <th
                            key={head}
                            className="border-y border-blue-gray-100 bg-blue-gray-50/50 p-4"
                            >
                            <Typography
                                variant="small"
                                color="blue-gray"
                                className="font-normal leading-none opacity-70"
                            >
                                {head}
                            </Typography>
                            </th>
                        ))}
                        </tr>
                    </thead>
                    <tbody>
                        {TABLE_ROWS.map(
                        (
                            {
                            id,
                            name,
                            gender,
                            qualification,
                            },
                            index,
                        ) => {
                            const isLast = index === TABLE_ROWS.length - 1;
                            const classes = isLast
                            ? "p-4"
                            : "p-4 border-b border-blue-gray-50";
            
                            return (
                            <tr key={id}>
                                <td className={classes}>
                                <Typography
                                    variant="small"
                                    color="blue-gray"
                                    className="font-normal"
                                >
                                    {id}
                                </Typography>
                                </td>
                                <td className={classes}>
                                <Typography
                                    variant="small"
                                    color="blue-gray"
                                    className="font-normal"
                                >
                                    {name}
                                </Typography>
                                </td>
                                <td className={classes}>
                                <Typography
                                    variant="small"
                                    color="blue-gray"
                                    className="font-normal"
                                >
                                    {gender}
                                </Typography>
                                </td>
                                <td className={classes}>
                                <Typography
                                    variant="small"
                                    color="blue-gray"
                                    className="font-normal"
                                >
                                    {qualification}
                                </Typography>
                                </td>
                                <td className={classes}>
                                <div>
                                <Tooltip content="Check">
                                    <IconButton onClick={togglePopup} variant="text">
                                    <EyeIcon className="h-4 w-4" />
                                    </IconButton>
                                </Tooltip>
                                <Tooltip content="Edit">
                                    <IconButton variant="text">
                                    <PencilIcon className="h-4 w-4" />
                                    </IconButton>
                                </Tooltip>
                                <Tooltip content="Delete">
                                    <IconButton variant="text">
                                    <TrashIcon className="h-4 w-4" />
                                    </IconButton>
                                </Tooltip>
                                </div>
                                
                                </td>
                            </tr>
                            );
                        },
                        )}
                    </tbody>
                    </table>
                </CardBody>
                </Card>

                {buttonPopup && <Popup
                    content={<div className="box-border w-50 h-50 bg-white">
                        <h1>mypopup</h1>
                        <div className="flex flex-col">
                            <div className="overflow-x-auto sm:-mx-6 lg:-mx-8">
                                <div className="inline-block min-w-full py-2 sm:px-6 lg:px-8">
                                <div className="overflow-hidden">
                                    <table className="min-w-full text-left text-sm font-light">
                                    <thead className="border-b font-medium dark:border-neutral-500">
                                        <tr>
                                        <th scope="col" className="px-6 py-4">#</th>
                                        <th scope="col" className="px-6 py-4">First</th>
                                        <th scope="col" className="px-6 py-4">Last</th>
                                        <th scope="col" className="px-6 py-4">Handle</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr
                                        className="border-b transition duration-300 ease-in-out hover:bg-neutral-100 dark:border-neutral-500 dark:hover:bg-neutral-600">
                                        <td className="whitespace-nowrap px-6 py-4 font-medium">1</td>
                                        <td className="whitespace-nowrap px-6 py-4">Mark</td>
                                        <td className="whitespace-nowrap px-6 py-4">Otto</td>
                                        <td className="whitespace-nowrap px-6 py-4">@mdo</td>
                                        </tr>
                                        <tr
                                        className="border-b transition duration-300 ease-in-out hover:bg-neutral-100 dark:border-neutral-500 dark:hover:bg-neutral-600">
                                        <td className="whitespace-nowrap px-6 py-4 font-medium">2</td>
                                        <td className="whitespace-nowrap px-6 py-4">Jacob</td>
                                        <td className="whitespace-nowrap px-6 py-4">Thornton</td>
                                        <td className="whitespace-nowrap px-6 py-4">@fat</td>
                                        </tr>
                                        <tr
                                        className="border-b transition duration-300 ease-in-out hover:bg-neutral-100 dark:border-neutral-500 dark:hover:bg-neutral-600">
                                        <td className="whitespace-nowrap px-6 py-4 font-medium">3</td>
                                        <td className="whitespace-nowrap px-6 py-4">Larry</td>
                                        <td className="whitespace-nowrap px-6 py-4">Wild</td>
                                        <td className="whitespace-nowrap px-6 py-4">@twitter</td>
                                        </tr>
                                    </tbody>
                                    </table>
                                </div>
                                </div>
                            </div>
                            </div>
                    </div>
                    }
                    handleClose={togglePopup}

                    
                    // {console.log(1)}
                />}
            </div>

        </>
    );
}

export default Doctor