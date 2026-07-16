import './App.css';

import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {

  return (

    <div
      style={{
        display: "flex",
        justifyContent: "space-around",
        marginTop: "40px"
      }}
    >

      <CourseDetails />

      <BookDetails />

      <BlogDetails />

    </div>

  );

}

export default App;