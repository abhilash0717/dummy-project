import { Component, component } from "react";
import axios from "axios";
const url = "http://localhost:4000/ApiTesting/storeTheData";
export default class ApiData extends Component {
  state = {
    dataFromDb: {
      bookIds: [],
    },
    successMessage: "",
    errorMessage: "",
  };

  getFromAPI = (e) => {
    var { bookIds } = this.state.dataFromDb;
    e.preventDefault();
    axios
      .get(
        "https://www.googleapis.com/books/v1/volumes?q=software+engineering&projection=lite"
      )
      .then((response) => {
        console.log(response.data.items);

        //adding bookids
        var id = [];
        for (var i = 0; i < response.data.items.length; i++) {
          id[i] = response.data.items[i].id;
        }
        bookIds.push(id);
        this.setState({ bookIds });
      })
      .catch();
    //ending bookids
  };

  sendToDb = (e) => {
    e.preventDefault();

    axios.post(url, this.state.dataFromDb)
    .then((response) => {
      this.setState({successMessage : response.data, errorMessage : ""})
    })
    .catch();
  };
  render() {
    const { bookIds } = this.state.dataFromDb;
    return (
      <>
        {JSON.stringify(this.state.dataFromDb)}
        <h1>Hi</h1>
        <button onClick={(e) => this.getFromAPI(e)}>
          {" "}
          Get the data from API
        </button>
        <button onClick={(e) => this.sendToDb(e)}>Send the data to DB</button>
      </>
    );
  }
}
