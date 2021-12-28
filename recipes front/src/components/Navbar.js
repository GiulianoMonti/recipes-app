import { Link } from "react-router-dom";
import React, { useContext } from "react";
import { useTheme } from "../hooks/useTheme";
// styles
import "./Navbar.css";
import Searchbar from "./Searchbar";
import { ThemeContext } from "../context/ThemeContext";

export default function Navbar() {
  const { color } = useTheme();
  return (
    <div className="navbar" style={{ background: color }}>
      <nav>
        <Link to="/" className="brand">
          <h1>Cooking G</h1>
        </Link>
        <Searchbar />

        <Link to="create">Create Recipe</Link>
      </nav>
    </div>
  );
}
