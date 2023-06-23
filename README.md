# Coding Test (Java) - README

This coding assignment is designed to assess your frontend and backend capabilities. It involves working with two JSON files, namely `Parent.json` and `Child.json`, which contain transaction and installment payment data, respectively.

## Parent.json

The `Parent.json` file contains an array of JSON objects, with each object representing transaction information. Each object includes the following values:

- `id`: The database row id.
- `sender`: The name or id of the sender.
- `receiver`: The name or id of the receiver.
- `totalAmount`: The total amount to be paid for a transaction.

## Child.json

The `Child.json` file also contains an array of JSON objects, representing installment payments. Each object includes the following values:

- `id`: The child's id.
- `parentId`: The parent transaction id (corresponding to the `id` in `Parent.json`).
- `paidAmount`: The amount paid in this installment.

Note:
- Not every parent object will have a corresponding child id (i.e., the child id/object is non-mandatory).
- A parent object may have multiple child ids.

## Tasks

### Task 1: Parent Transaction Table

Your first task is to create a table that displays all the parent transactions from `Parent.json`. You should implement a REST API with server-side pagination. Each page should display 2 rows, and the table should be sortable by the parent id.

The Parent table should have the following columns:

- Parent id
- Sender
- Receiver
- Total Amount
- Total Paid Amount (Sum of all paid amounts in the corresponding installment/child id)

Sample:

| ID  | Sender | Receiver | Total Amount | Total Paid Amount |
| --- | ------ | -------- | ------------ | ----------------- |
| 1   | ABC    | XYZ      | 200          | 100               |

### Task 2: Child Data

The second task involves displaying the child data when the user clicks on the "Total Paid Amount" column in the parent transaction table. You should implement a REST API to fetch the child data.

The Child table should have the following columns:

- Child id
- Sender
- Receiver
- Total Amount
- Paid Amount (amount paid in that particular installment)

Populate all the data sorted by id. No pagination is required for this table.

Sample:

| ID  | Sender | Receiver | Total Amount | Paid Amount |
| --- | ------ | -------- | ------------ | ----------- |
| 1   | ABC    | XYZ      | 200          | 10          |
| 2   | ABC    | XYZ      | 200          | 50          |

## Instructions

1. Clone this repository to your local machine.
2. Implement the required functionality using Java.
3. Commit your code to the repository.
4. Share the link to your GitHub repository with us upon completion.

Feel free to provide any additional documentation or notes in the repository to help us understand your implementation better.
