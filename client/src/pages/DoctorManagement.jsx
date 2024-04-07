import Header from "../components/Header";
import MenuAdmin from "../components/MenuAdmin";
const Schedule = () => {


    return (
        <>
            <Header role='admin' />
            <div className="flex">
                <MenuAdmin />
                Doctor
            </div>

        </>
    );
}

export default Schedule