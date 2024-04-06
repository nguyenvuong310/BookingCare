import HeaderAdmin from "../components/HeaderAdmin";

import { PencilIcon, EyeIcon, ArchiveBoxXMarkIcon, TrashIcon } from "@heroicons/react/24/solid";
import {
    ArrowDownTrayIcon,
    MagnifyingGlassIcon,
    PlusCircleIcon
} from "@heroicons/react/24/outline";
import {
    Card,
    CardHeader,
    Typography,
    Button,
    CardBody,
    Chip,
    CardFooter,
    Avatar,
    IconButton,
    Tooltip,
    Input,
} from "@material-tailwind/react";

import { useParams } from "react-router-dom";
import { getDepartment, delDepartment } from "../service/userService";
import React, { useEffect, useState } from "react";
const TABLE_HEAD = ["ID", "Name", "Sympton", "Location", ""];


const TABLE_ROWS = [
    {
        id: "1",
        name: "Department 1",
        symton: "symton1",
        location: "Location 1",
    },
    {
        id: "2",
        name: "Department 2",
        symton: "symton2",
        location: "Location 2",
    },
    {
        id: "3",
        name: "Department 3",
        symton: "symton3",
        location: "Location 3",
    },
];

const AdminDepartment = () => {
    const params = useParams();
    const hospital_id = params.hospital_id;
    const [departmentData, setDepartmentData] = useState(null);
    const [reset, setReset] = useState(false);
    console.log(hospital_id)
    useEffect(() => {
        // Define an async function inside useEffect to fetch data
        const fetchData = async () => {
            try {
                // Call the getHospital function from the service
                const data = await getDepartment(hospital_id);
                console.log("cc", data)

                // Update state with the fetched data
                setDepartmentData(data.data);
            } catch (error) {
                // Handle errors if any
                console.error('Failed to fetch hospital data:', error);
            }
        };
        fetchData();
    }, []);
    const deleteDepartment = async (id) => {
        console.log(id)
        res = await delDepartment(id)


        const data = await getDepartment(hospital_id);
        console.log("department", data)

        // Update state with the fetched data
        setDepartmentData(data.data);
    }
    return (
        <>
            <HeaderAdmin />
            <div>
                <h1>Home Hospital</h1>

                <Card className="h-full w-full">
                    <CardHeader floated={false} shadow={false} className="rounded-none">
                        <div className="mb-4 flex flex-col justify-between gap-8 md:flex-row md:items-center">
                            <div>
                                <Typography variant="h5" color="blue-gray">
                                    Department of Hospital {hospital_id}
                                </Typography>
                                <Typography color="gray" className="mt-1 font-normal">
                                    These are overview about Department
                                </Typography>
                            </div>
                            <div className="flex w-full shrink-0 gap-2 md:w-max">
                                <div className="w-full md:w-72">
                                    <Input
                                        label="Search"
                                        icon={<MagnifyingGlassIcon className="h-5 w-5" />}
                                    />
                                </div>
                                <Button className="flex items-center gap-3" size="sm">
                                    ADD <PlusCircleIcon strokeWidth={2} className="h-4 w-4" />
                                </Button>
                            </div>
                        </div>
                    </CardHeader>
                    <CardBody className="overflow-scroll px-0">
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
                                {departmentData && departmentData.length > 0 && departmentData.map(
                                    (
                                        department,
                                        index
                                    ) => {
                                        const isLast = index === departmentData.length - 1;
                                        const classes = isLast
                                            ? "p-4"
                                            : "p-4 border-b border-blue-gray-50";

                                        return (
                                            <tr key={index}>
                                                <td className={classes}>
                                                    <div className="flex items-center gap-3">
                                                        {/* <Avatar
                                                            src={img}
                                                            alt={name}
                                                            size="md"
                                                            className="border border-blue-gray-50 bg-blue-gray-50/50 object-contain p-1"
                                                        /> */}
                                                        <Typography
                                                            variant="small"
                                                            color="blue-gray"
                                                            className="font-bold"
                                                        >
                                                            {index + 1}
                                                        </Typography>
                                                    </div>
                                                </td>
                                                <td className={classes}>
                                                    <Typography
                                                        variant="small"
                                                        color="blue-gray"
                                                        className="font-normal"
                                                    >
                                                        {department.name}
                                                    </Typography>
                                                </td>
                                                <td className={classes}>
                                                    <Typography
                                                        variant="small"
                                                        color="blue-gray"
                                                        className="font-normal"
                                                    >
                                                        {department.symptom}
                                                    </Typography>
                                                </td>
                                                <td className={classes}>
                                                    <Typography
                                                        variant="small"
                                                        color="blue-gray"
                                                        className="font-normal"
                                                    >
                                                        {department.location}
                                                    </Typography>
                                                </td>

                                                <td className={classes}>
                                                    <Tooltip content="View Hospital Detail">
                                                        <IconButton variant="text">
                                                            <EyeIcon className="h-4 w-4" />
                                                        </IconButton>
                                                    </Tooltip>
                                                    <Tooltip content="Edit Hospital">
                                                        <IconButton variant="text">
                                                            <PencilIcon className="h-4 w-4" />
                                                        </IconButton>
                                                    </Tooltip>
                                                    <Tooltip content="Remove Hospital" >
                                                        <IconButton variant="text" onClick={() => deleteDepartment(department.id)}>
                                                            <TrashIcon className="h-4 w-4" />
                                                        </IconButton>
                                                    </Tooltip>
                                                </td>
                                            </tr>
                                        );
                                    },
                                )}
                            </tbody>
                        </table>
                    </CardBody>
                    <CardFooter className="flex items-center justify-between border-t border-blue-gray-50 p-4">
                        <Button variant="outlined" size="sm">
                            Previous
                        </Button>
                        <div className="flex items-center gap-2">
                            <IconButton variant="outlined" size="sm">
                                1
                            </IconButton>
                            <IconButton variant="text" size="sm">
                                2
                            </IconButton>
                            <IconButton variant="text" size="sm">
                                3
                            </IconButton>
                            <IconButton variant="text" size="sm">
                                ...
                            </IconButton>
                            <IconButton variant="text" size="sm">
                                8
                            </IconButton>
                            <IconButton variant="text" size="sm">
                                9
                            </IconButton>
                            <IconButton variant="text" size="sm">
                                10
                            </IconButton>
                        </div>
                        <Button variant="outlined" size="sm">
                            Next
                        </Button>
                    </CardFooter>
                </Card>

            </div>
        </>
    );
}

export default AdminDepartment;