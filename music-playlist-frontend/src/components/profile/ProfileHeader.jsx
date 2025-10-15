import { Link } from "react-router-dom";
import { FiArrowLeft } from "react-icons/fi";

const ProfileHeader = () => {
    return (
    <header className="border-divider sticky top-0 z-40 bg-white">
        <div className="card-header flex items-center justify-between">
            <Link className="btn-icon-text ml-3" to="/profile">
                <FiArrowLeft size={24} />
            </Link>
            <h1 className="font-semibold text-4xl m-3">프로필 수정</h1>
            <div className="w-6"></div>
        </div>
    </header>
    );
};

export default ProfileHeader;