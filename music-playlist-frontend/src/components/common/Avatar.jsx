import { FiUser } from "react-icons/fi";

const SIZES = {
  "extra-small": { class: "w-7 h-7", icon: 14 },
  small: { class: "w-8 h-8", icon: 16 },
  medium: { class: "w-10 h-10", icon: 20 },
  large: { class: "w-20 h-20", icon: 40 },
  xlarge: { class: "w-24 h-24", icon: 48 },
};

const Avatar = ({
  user,
  size = "medium",
  className = "",
  showBorder = false,
  borderColor = "black",
}) => {
  const sizeConfig = SIZES[size];
  const borderClass = showBorder ? `ring-2 ring-${borderColor}` : "";

  const API_URL = import.meta.env.VITE_API_URL || "http://localhost:8080";
  const imageUrl = user?.profileImageUrl
    ? `${API_URL}${user.profileImageUrl}`
    : null;

  return (
    <div
      className={`${sizeConfig.class} rounded-full overflow-hidden bg-gray-300 flex-shrink-0 ${borderClass} ${className} relative`}
    >
      {imageUrl ? (
        <img
          src={imageUrl}
          alt={user?.username || "User"}
          className="w-full h-full object-cover"
        />
      ) : (
        <div className="w-full h-full flex items-center justify-center bg-gradient-to-br from-blue-400 to-sky-400">
          <FiUser size={sizeConfig.icon} className="text-white" />
        </div>
      )}
    </div>
  );
};

export default Avatar;