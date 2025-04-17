# Data Structures Assignment Submission

**Student:** Yerzat

This repository contains the implementation of the Data Structures assignment, as required:

1. **Interface and Physical Structures**
   - `MyList<T>`: Custom list interface; extends `Iterable<T>`.
   - `MyArrayList<T>`: Dynamic array implementation; uses private `Object[] data` and `int size`.
   - `MyLinkedList<T>`: Doubly linked list implementation; prevents loops and supports bidirectional traversal.

2. **Logical Data Structures**
   - `MyStack<T>`: LIFO stack built on `MyLinkedList<T>`.
   - `MyQueue<T>`: FIFO queue built on `MyLinkedList<T>`.
   - `MyMinHeap<T>`: Min-heap built on array storage; generic with `T extends Comparable<? super T>`.

3. **Assignment Constraints**
   - **No use of `java.util.*`** except `Iterator`.
   - All required methods implemented and tested.
   - Sorting via `Comparable` casts with suppressed unchecked warnings.

4. **Testing**
   - Separate test classes for each structure:
     - `TestMyArrayList`  
     - `TestMyLinkedList`  
     - `TestMyStack`  
     - `TestMyQueue`  
     - `TestMyMinHeap`  
   - `Main` class demonstrates basic operations.
   - `TestAll` (or updated `Main`) runs all tests in sequence.

5. **Commits & Version Control**
   - **7+ meaningful commits** reflecting incremental development:
     1. Initialize `MyList` and `MyArrayList`.
     2. Implement missing `MyArrayList` methods.
     3. Finalize `MyLinkedList` implementation.
     4. Add `MyStack`, `MyQueue`, `MyMinHeap` and their tests.
     5. Add `Main` demo and `TestAll` runner.
     6. README creation and updates.
     7. Suppress warnings and refactor per feedback.


**Please review**: this submission fulfills the specification. All tests pass, code follows assignment rules, and version history documents the development process.

