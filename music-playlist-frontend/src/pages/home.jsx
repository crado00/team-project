import { FiLogOut } from "react-icons/fi";
import * as Tabs from "@radix-ui/react-tabs";
const Home = () => {
  return (
    <div className="bg-red-300 min-h-screen max-w-2xl mx-auto flex flex-col items-center">
        <header className="top-0 w-full z-40 bg-white flex justify-between items-center">
            <h1 className="text-3xl text-black p-2">Music Playlist App</h1>
            <div className="flex justify-end pr-4">
                <Tabs.Root>
                  <Tabs.List>
                    <Tabs.TabsTrigger>
                      
                    </Tabs.TabsTrigger>
                  </Tabs.List>
                </Tabs.Root>
                <button
                    className="text-black hover:text-red-500 transition-colors"
                    title="Logout"
                    aria-label="Logout"
                >
                    <FiLogOut size={24} />
                </button>
            </div>
        </header>
        <div className="pt-5">
          <h1>Welcome to the Music Playlist App</h1>
          <p>Discover and manage your favorite music playlists.</p>
        </div>
        <div className="fixed bottom-0 w-full z-40 bg-white flex">
        </div>
    </div>
  );
};

export default Home;