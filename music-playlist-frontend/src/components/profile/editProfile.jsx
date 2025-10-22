import { useEffect, useState } from "react";
import { FiX } from "react-icons/fi";
import userService from "../../services/user";
import Avatar from "../common/Avatar";
// import useAuthStore from "../store/authStore";

const EditProfile = ({ onClose, currentProfile }) => {
 //const { user, setAuth } = useAuthStore();

  const [formData, setFormData] = useState({
    username: "",
    fullName: "",
    residentialArea: "",
    selfIntroduction: "",
    profileImageUrl: null,
  });

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  // ✅ 초기값 세팅
  /*
  useEffect(() => {
    if (currentProfile) {
      setFormData({
        username: currentProfile.username || "",
        fullname: currentProfile.fullname || "",
        residential_area: currentProfile.residential_area || "",
        bio: currentProfile.bio || "",
      });
    } else if (user) {
      setFormData({
        username: user.username || "",
        fullname: user.fullname || "",
        residential_area: user.residential_area || "",
        bio: user.bio || "",
      });
    }
  }, [currentProfile, user]);
*/
  // ✅ 입력 변경 핸들러
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // ✅ 프로필 수정 요청
  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");

    if (formData.username.trim().length < 2) {
      setError("Username must be at least 2 characters.");
      return;
    }

    try {
      setLoading(true);
      const updatedProfile = await userService.updateProfile(formData);

      const updatedUser = {
        ...user,
        ...updatedProfile,
      };

      setAuth({
        user: updatedUser,
        isAuthenticated: true,
        loading: false,
        error: null,
      });

      localStorage.setItem("user", JSON.stringify(updatedUser));
      onClose?.(); // ✅ 모달 닫기
    } catch (err) {
      console.error(err);
      setError(err.response?.data?.message || "Failed to update profile");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50 p-4">
      <div className="bg-white rounded-lg w-full max-w-md">
        {/* Header */}
        <div className="flex items-center justify-between p-4 border-b border-gray-200">
          <h2 className="text-xl font-bold">Edit Profile</h2>
          <button
            onClick={onClose}
            className="p-2 hover:bg-gray-100 rounded-full transition-colors"
          >
            <FiX size={24} />
          </button>
        </div>

        {/* Form */}
        <form onSubmit={handleSubmit} className="p-4 flex flex-col gap-4">
          <div className="flex flex-col justify-center items-center space-y-3">
            <Avatar size="large" className="self-center" />
            <p className="text-center text-2xl">{formData.username || "user"}</p>
          </div>
          {error && (
            <div className="text-red-500 bg-red-100 border border-red-300 p-2 rounded-md">
              {error}
            </div>
          )}

          <div className="flex flex-col">
            <label className="mb-1 font-semibold text-gray-700" htmlFor="username">
              Username
            </label>
            <input
              id="username"
              name="username"
              value={formData.username}
              onChange={handleChange}
              className="border p-2 rounded-lg focus:ring-2 focus:ring-blue-400"
              placeholder="Enter username"
            />
          </div>

          <div className="flex flex-col">
            <label className="mb-1 font-semibold text-gray-700" htmlFor="fullname">
              Full Name
            </label>
            <input
              id="fullName"
              name="fullName"
              value={formData.fullName}
              onChange={handleChange}
              className="border p-2 rounded-lg focus:ring-2 focus:ring-blue-400"
              placeholder="Enter full name"
            />
          </div>

          <div className="flex flex-col">
            <label className="mb-1 font-semibold text-gray-700" htmlFor="residential_area">
              Residential Area
            </label>
            <input
              id="residentialArea"
              name="residentialArea"
              value={formData.residentialArea}
              onChange={handleChange}
              className="border p-2 rounded-lg focus:ring-2 focus:ring-blue-400"
              placeholder="Enter your area"
            />
          </div>

          <div className="flex flex-col">
            <label className="mb-1 font-semibold text-gray-700" htmlFor="bio">
              Self Introduction
            </label>
            <textarea
              id="selfIntroduction"
              name="selfIntroduction"
              rows="4"
              value={formData.selfIntroduction}
              onChange={handleChange}
              className="border p-2 rounded-lg focus:ring-2 focus:ring-blue-400 resize-none"
              placeholder="Tell us about yourself"
            ></textarea>
          </div>

          {/* Buttons */}
          <div className="flex space-x-2 pt-2">
            <button
              type="button"
              onClick={onClose}
              className="flex-1 bg-gray-200 text-gray-700 p-2 rounded-lg hover:bg-gray-300 transition"
            >
              Cancel
            </button>
            <button
              type="submit"
              disabled={loading}
              className="flex-1 bg-blue-500 text-white p-2 rounded-lg hover:bg-blue-600 transition disabled:opacity-50"
            >
              {loading ? "Saving..." : "Save"}
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default EditProfile;
