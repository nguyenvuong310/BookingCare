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
import { useEffect } from "react";
import Popup from 'reactjs-popup'

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
    console.log(hospital_id)

    const mystyle = {
        color: "red"
    };

    useEffect(() => {
        fetch('http://localhost:8080/api/Department/GetAllDepartment')
            .then((res) => {
                return res.json();
            })
            .then((data) => {
                console.log(data);
            });
    }, []);
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
                                {TABLE_ROWS.map(
                                    (
                                        {
                                            id,
                                            name,
                                            location,
                                            symton
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
                                                            {id}
                                                        </Typography>
                                                    </div>
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
                                                        {symton}
                                                    </Typography>
                                                </td>
                                                <td className={classes}>
                                                    <Typography
                                                        variant="small"
                                                        color="blue-gray"
                                                        className="font-normal"
                                                    >
                                                        {location}
                                                    </Typography>
                                                </td>

                                                <td className={classes}>
                                                    <Popup modal trigger={<button>
                                                        <Tooltip content="View Hospital Detail">
                                                            <IconButton variant="text">
                                                                <EyeIcon className="h-4 w-4" />
                                                            </IconButton>
                                                        </Tooltip></button>} >
                                                        Modal Content
                                                    </Popup>
                                                    
                                                    <Tooltip content="Edit Hospital" >
                                                        <IconButton variant="text">
                                                            <PencilIcon className="h-4 w-4" />
                                                        </IconButton>
                                                    </Tooltip>
                                                    <Tooltip content="Remove Hospital">
                                                        <IconButton variant="text">
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

                </Card>

                <Popup modal trigger={<button>Click Me</button>}>
                    Modal Content
                </Popup>
            </div>
        </>
    );
}

export default AdminDepartment;