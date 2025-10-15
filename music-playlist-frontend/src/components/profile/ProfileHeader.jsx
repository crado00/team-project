import { Link } from "react-router-dom";
import { FiArrowLeft } from "react-icons/fi";

const ProfileHeader = ({ username }) => {
    return (
    <header className="border-divider sticky top-0 z-40 bg-white">
        <div className="card-header flex items-center justify-between">
            <Link className="btn-icon-text" to="/">
                <FiArrowLeft size={24} />
            </Link>
            <h1 className="font-semibold text-lg">{username}</h1>
            <div className="w-6"></div>
        </div>
    </header>
    );
};

export default ProfileHeader;