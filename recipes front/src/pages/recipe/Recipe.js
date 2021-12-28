import "./Recipe.css";
import { useParams, useState } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { useFetch } from "../../hooks/useFetch";
import { useEffect } from "react";
import { useTheme } from "../../hooks/useTheme";
//style

export default function Recipe() {
  const { id } = useParams();
  const url = "http://localhost:8080/recipes/" + id;
  const { data: recipe, isPending, error } = useFetch(url);
  const { mode } = useTheme();
  const navigate = useNavigate();
  useEffect(() => {
    if (error) {
      // redirect
      setTimeout(() => {
        navigate("/");
      }, 2000);
    }
  }, [error]);

  return (
    <div className={`recipe ${mode}`}>
      {isPending && <p>Loading...</p>}
      {error && <p>{error}</p>}
      {recipe && (
        <>
          <h2 className="page-title">{recipe.title}</h2>
          <p>Takes{recipe.copokingTime} to cook.</p>
          <ul>
            {recipe.ingredients.map((ing) => (
              <li key={ing}>{ing}</li>
            ))}
          </ul>
          <p className="method">{recipe.method}</p>
        </>
      )}
    </div>
  );
}
