const Button = ({
  children,
  onClick,
  type = "button",
  variant = "primary",
  disabled = false,
  className = "",
  icon = null,
}) => {
  const baseStyles =
    "w-full py-3 rounded-xl font-semibold text-base transition-all duration-200 flex items-center justify-center";

  const variants = {
    primary:
      "bg-gradient-to-r from-green-500 to-blue-400 text-white hover:shadow-lg transform hover:scale-[1.02] disabled:opacity-50",
    secondary:
      "bg-white border border-gray-200 text-gray-700 hover:bg-gray-50 hover:shadow-md transform hover:scale-[1.02]",
    dark: "db-gray-900 text-white hover:bg-gray-800 hover:shadow-md transform hover:scale-[1.02]",
  };

  return (
    <button
      type={type}
      onClick={onClick}
      disabled={disabled}
      className={`${baseStyles} ${variants[variant]} ${className}`}
    >
      {icon && <span className="mr-3">{icon}</span>}
      {children}
    </button>
  );
};

export default Button;
